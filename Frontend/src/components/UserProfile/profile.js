import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import { BsPersonFill } from 'react-icons/bs';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';

const useAuth = () => {
  const [userData, setUserData] = useState(null);

  useEffect(() => {
    // const userData = fetchUserData(); 
    // setUserData(userData);
    const fetchedUserData = {
        fullName: 'Riya Patel',
        email: 'riya@example.com',
        age: 23,
        city: 'New York',
        country: 'USA',
      };
      setUserData(fetchedUserData);
    }, []);

    return [userData, setUserData]; 
};

const UserProfile = () => {
    const [userData, setUserData] = useAuth();

  const [isEditing, setIsEditing] = useState(false);

  const handleEdit = () => {
    setIsEditing(true);
  };

  const handleSave = () => {
    setIsEditing(false);
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setUserData({ ...userData, [name]: value });
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

              <Form.Group controlId="formEmail"style={{ marginTop: '1rem' }}>
                <Form.Label>Email</Form.Label>
                <Form.Control
                  type="email"
                  name="email"
                  value={userData.email}
                  onChange={handleInputChange}
                  readOnly={!isEditing}
                  className="rounded-pill"
                />
              </Form.Group>

              <Form.Group controlId="formAge" style={{ marginTop: '1rem' }}>
                <Form.Label>Age</Form.Label>
                <Form.Control
                  type="number"
                  name="age"
                  value={userData.age}
                  onChange={handleInputChange}
                  readOnly={!isEditing}
                  className="rounded-pill"
                />
              </Form.Group>

              <Form.Group controlId="formCity" style={{ marginTop: '1rem' }}>
                <Form.Label>City</Form.Label>
                <Form.Control
                  type="text"
                  name="city"
                  value={userData.city}
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
                <Button variant="primary" onClick={handleSave} className="rounded-pill" style={{ marginTop: '2rem', width: '3cm' }}>
                  Save
                </Button>
              ) : (
                <Button variant="secondary" onClick={handleEdit} className="rounded-pill" style={{ marginTop: '2rem', width: '3cm' }}>
                  Edit
                </Button>
              )}
            </Form>
          </Col>
        </Row>
      </Container>

      <Footer />
    </div>
  );
};

export default UserProfile;