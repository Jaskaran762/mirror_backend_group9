import React, { useState } from 'react';
import { Container, Row, Col, Form, Button, Toast } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Signup = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [phone, setPhone] = useState('');
  const [interest, setIntrest] = useState('');
  const [homeCountry, setHomeCountry] = useState('Canada');
  const [isLoading, setIsLoading] = useState(false);

  const [showSuccessToast, setShowSuccessToast] = useState(false); 
  const [showErrorToast, setShowErrorToast] = useState(false); 


  const handleChange = (e) => {
    const { name, value } = e.target;
    switch (name) {
      case 'name':
        setName(value);
        break;
      case 'email':
        setEmail(value);
        break;
      case 'password':
        setPassword(value);
        break;
      case 'phone':
        setPhone(value);
        break;
      case 'homeCountry':
        setHomeCountry(value);
        break;
      case 'interest':
        setIntrest(value);
        break;
      default:
        break;
    }
  };
  const changePage=useNavigate();
  const handleSubmit = async (e) => {
    e.preventDefault();

    setIsLoading(true);
    const homeCountryValueMap = {
      Canada: 1,
      USA: 2,
      India: 3,
      London: 4,
      France: 5,
      Paris: 6,
    };

    const userObject = {
      interest,
      password,
      name,
      email,
      phone,
      homeCountry: homeCountryValueMap[homeCountry], 
    };

    try {
      const response = await axios.post('https://group09.onrender.com/auth/register', userObject);
      console.log('API response:', response.data);

      setIsLoading(false); 
      setShowSuccessToast(true); 
      setTimeout(() => {
        setShowSuccessToast(false);
        changePage('/landing');
      }, 2000);
    } 
    catch (error) {
      setIsLoading(false); 
      console.error('API error:', error);
      setShowErrorToast(true);
      setTimeout(() => {
        setShowErrorToast(false);
      }, 2000);
    }
  };

  return (
    <div
      className="registerPage"
      style={{
        backgroundImage: `url('https://img.freepik.com/free-photo/top-view-passport-tickets-camera_23-2148786120.jpg?w=1060&t=st=1687293728~exp=1687294328~hmac=0237669a31b51fa53dc2b368ce4a4b1c6695c7f9f20bed1cab6f09b88d09f5c4')`,
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        backgroundPosition: 'right',
      }}
    >
      <Container className="vh-100">
        <Row className="justify-content-left align-items-center h-100">
          <Col xs={10} md={3} lg={5}>
            <div className="signupContainer p-4 rounded-lg shadow" style={{ backgroundColor: '#ffffff' }}>
              <h3 className="title">Want to plan your trip?</h3>
              <h4 className="title">Sign up with Tripify</h4>
              <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formName">
                  <Form.Label>Name</Form.Label>
                  <Form.Control type="text" name="name" placeholder="Enter your name" value={name} onChange={handleChange} />
                </Form.Group>
                <Form.Group controlId="formEmail">
                  <Form.Label>Email address</Form.Label>
                  <Form.Control type="email" name="email" placeholder="Enter your email" value={email} onChange={handleChange} />
                </Form.Group>
                <Form.Group controlId="formPassword">
                  <Form.Label>Password</Form.Label>
                  <Form.Control type="password" name="password" placeholder="Choose a password" value={password} onChange={handleChange} />
                </Form.Group>
                <Form.Group controlId="formPhone">
                  <Form.Label>Phone</Form.Label>
                  <Form.Control type="text" name="phone" placeholder="Enter your phone number" value={phone} onChange={handleChange} />
                </Form.Group>
                <Form.Group controlId="formName">
                  <Form.Label>Your Interest</Form.Label>
                  <Form.Control type="text" name="interest" placeholder="Enter your interest" value={interest} onChange={handleChange} />
                </Form.Group>
                <br />
                <Form.Group controlId="formCountrySelect">
                  <Form.Label>Country</Form.Label>
                  <Form.Control as="select" name="homeCountry" value={homeCountry} onChange={handleChange}>
                    <option value="Canada">Canada</option>
                    <option value="USA">USA</option>
                    <option value="India">India</option>
                    <option value="London">London</option>
                    <option value="France">France</option>
                    <option value="Paris">Paris</option>
                  </Form.Control>
                </Form.Group>
                <br />
                <Button variant="primary" className="submitButton" type="submit">
                  {isLoading ? 'Loading...' : 'Register'}
                </Button>
              </Form>
            </div>
          </Col>
        </Row>
      </Container>
      <Toast
        show={showSuccessToast}
        onClose={() => setShowSuccessToast(false)}
        style={{
          position: 'absolute',
          top: '20px',
          right: '20px',
          zIndex: 9999,
          backgroundColor: '#28a745',
          color: '#ffffff', 
        }}
        delay={2000} 
        autohide
      >
        <Toast.Body>Registration successful! Redirecting...</Toast.Body>
      </Toast>

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
        <Toast.Body>Registration failed. Please try again.</Toast.Body>
      </Toast>
    </div>
  );
};

export default Signup;
