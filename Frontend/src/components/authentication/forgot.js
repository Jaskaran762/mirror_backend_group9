import React from 'react';
import { Container, Form, Button, Row, Col} from 'react-bootstrap';
import { Link } from 'react-router-dom';

const ForgotPassword = () => {
  return (
    <div
      className="loginPage"
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
              <h1 className="text-center mb-4">Reset Password</h1>
              <Form>
                <Form.Group controlId="formUsername">
                  <Form.Label>Email address</Form.Label>
                  <Form.Control type="text" className="formInput" />
                </Form.Group>

                <Form.Group controlId="formUsername">
                  <Form.Label>New Password</Form.Label>
                  <Form.Control type="text" className="formInput" />
                </Form.Group>
              
                <Button variant="primary" className="submitButton my-2" type="submit">
                  Reset Password
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
