import React, { useState, useEffect, useN } from 'react';
import axios from 'axios';
import { Container, Row, Col, Form, Button, Toast } from 'react-bootstrap';
import { BsPersonFill } from 'react-icons/bs';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import { Link, useNavigate } from 'react-router-dom';

const useAuth = () => {
  const [userData, setUserData] = useState(null);
  
  useEffect(() => {
    const fetchUserData = async () => {
      const apiUrl = 'http://localhost:8090/getProfile';
      const token = window.localStorage.getItem('token');
      const headers = {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer '.concat(token)
      };

      try {
        const response = await axios.post(apiUrl, {}, { headers: headers });
        setUserData(response.data); // Assuming the server returns the entire user data object
      } catch (error) {
        console.error('API error:', error);
      }
    };

    fetchUserData();
  }, []);

  return [userData, setUserData];
};

const UserProfile = () => {
  const [userData, setUserData] = useAuth();
  const [isEditing, setIsEditing] = useState(false);
  const [showErrorToast, setShowErrorToast] = useState(false);

  const handleEdit = () => {
    setIsEditing(true);
  };

  const handleSave = () => {
    setIsEditing(false);
    // Save the updated user data to the server if needed.
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    // Note: Since the userData object is immutable, create a new object and update the specific field.
    const updatedUserData = { ...userData, [name]: value };
    setUserData(updatedUserData);
  };

  const changepage = useNavigate();
  const handleResetPassword = () => {
    changepage('/resetpassword');
  };

  if (!userData) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <HomeNavbar />

      <Container>
        <Row className="my-4">
          <Col md={{ span: 6, offset: 3 }}>
            <div className="text-center">
              <BsPersonFill size={100} />
              <h1 style={{ marginTop: '20px' }}>User Profile</h1>
            </div>

            <Form>
              <Form.Group controlId="formFullName" style={{ marginTop: '1rem' }}>
                <Form.Label>Full Name</Form.Label>
                <Form.Control
                  type="text"
                  name="fullName"
                  value={userData.fullName}
                  onChange={handleInputChange}
                  readOnly={!isEditing}
                  className="rounded-pill"
                />
              </Form.Group>

              <Form.Group controlId="formEmail" style={{ marginTop: '1rem' }}>
                <Form.Label>Email</Form.Label>
                <Form.Control
                  type="email"
                  name="email"
                  value={userData.email}
                  onChange={handleInputChange}
                  readOnly
                  className="rounded-pill"
                />
              </Form.Group>

              <Form.Group controlId="formPassword" style={{ marginTop: '1rem' }}>
                <Form.Label>Password</Form.Label>
                <Form.Control
                  type="password"
                  name="password"
                  value={userData.password}
                  onChange={handleInputChange}
                  readOnly
                  className="rounded-pill"
                />
              </Form.Group>

              <Link to="/resetpassword" onClick={handleResetPassword}>
                Reset Password
              </Link>

              <Form.Group controlId="formContact" style={{ marginTop: '1rem' }}>
                <Form.Label>Contact No</Form.Label>
                <Form.Control
                  type="text"
                  name="contact"
                  value={userData.contact}
                  onChange={handleInputChange}
                  readOnly={!isEditing}
                  className="rounded-pill"
                />
              </Form.Group>

              <Form.Group controlId="formInterest" style={{ marginTop: '1rem' }}>
                <Form.Label>Interest</Form.Label>
                <Form.Control
                  type="text"
                  name="interest"
                  value={userData.interest}
                  onChange={handleInputChange}
                  readOnly={!isEditing}
                  className="rounded-pill"
                />
              </Form.Group>

              <Form.Group controlId="formCountry" style={{ marginTop: '1rem' }}>
                <Form.Label>Country</Form.Label>
                <Form.Control
                  type="text"
                  name="country"
                  value={userData.country}
                  onChange={handleInputChange}
                  readOnly={!isEditing}
                  className="rounded-pill"
                />
              </Form.Group>

              {isEditing ? (
                <Button
                  variant="primary"
                  onClick={handleSave}
                  className="rounded-pill"
                  style={{ marginTop: '2rem', width: '3cm' }}
                >
                  Save
                </Button>
              ) : (
                <Button
                  variant="secondary"
                  onClick={handleEdit}
                  className="rounded-pill"
                  style={{ marginTop: '2rem', width: '3cm' }}
                >
                  Edit
                </Button>
              )}
            </Form>
          </Col>
        </Row>
      </Container>

      <Footer />

      <Toast
        show={showErrorToast}
        onClose={() => setShowErrorToast(false)}
        style={{
          position: 'absolute',
          top: '20px',
          right: '20px',
          zIndex: 9999,
          backgroundColor: '#dc3545',
          color: '#ffffff',
        }}
        delay={2000}
        autohide
      >
        <Toast.Body>Something went wrong..</Toast.Body>
      </Toast>
    </div>
  );
};

export default UserProfile;
