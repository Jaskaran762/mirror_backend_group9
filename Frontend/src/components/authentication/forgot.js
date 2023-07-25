import React, { useState } from 'react';
import axios from 'axios';
import { Container, Form, Button, Row, Col } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const ForgotPassword = () => {
  const [email, setEmail] = useState('');

  const handleForgotPassword = async () => {
    const apiUrl = 'https://group09.onrender.com/auth/forgotpassword';
    const headers = {
      'Content-Type': 'application/json',
    };
    const requestBody = {
      "email": email,
    };

    try {
      const response = await axios.post(apiUrl, requestBody, { headers });
      console.log('Response:', response.data);
      // Handle the API response as needed
    } catch (error) {
      console.error('API error:', error);
      // Handle the error
    }
  };

  return (
    <div className="loginPage"
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
            <div className="loginContainer p-4 rounded-lg shadow">
              <h2 className="text-center mb-4">Enter username</h2>
              <Form>
                <Form.Group controlId="formUsername">
                  <Form.Label>Email address</Form.Label>
                  <Form.Control
                    type="text"
                    className="formInput"
                    value={email} // Bind the value to the email state
                    onChange={(e) => setEmail(e.target.value)} // Update email state on change
                  />
                </Form.Group>
                <Button
                  variant="primary"
                  className="submitButton my-2"
                  type="button"
                  onClick={handleForgotPassword} // Call handleForgotPassword on button click
                >
                  Send OTP
                </Button>
              </Form>
            </div>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default ForgotPassword;