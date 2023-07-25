import React, { useState } from 'react';
import { Container, Form, Button, Row, Col } from 'react-bootstrap';

const Resetpwd = () => {
  const [oldPassword, setOldPassword] = useState('');
  const [newPassword, setNewPassword] = useState('');
  const [retypeNewPassword, setRetypeNewPassword] = useState('');
  const [passwordsMatch, setPasswordsMatch] = useState(false);
  const [oldAndNewDifferent, setOldAndNewDifferent] = useState(false);

  const handleOldPasswordChange = (e) => {
    setOldPassword(e.target.value);
    setOldAndNewDifferent(e.target.value !== newPassword);
  };

  const handleNewPasswordChange = (e) => {
    setNewPassword(e.target.value);
    setPasswordsMatch(e.target.value === retypeNewPassword);
    setOldAndNewDifferent(e.target.value !== oldPassword);
  };

  const handleRetypeNewPasswordChange = (e) => {
    setRetypeNewPassword(e.target.value);
    setPasswordsMatch(e.target.value === newPassword);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (passwordsMatch && oldAndNewDifferent) {
      console.log('Password reset successful!');
    } else {
      console.log('Passwords do not match or Old and New Passwords are the same!');
    }
  };

  return (
    <div
      className="resetPage"
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
              <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formEmail">
                  <Form.Label>Email address</Form.Label>
                  <Form.Control type="text" className="formInput" />
                </Form.Group>

                <Form.Group controlId="formPassword">
                  <Form.Label>Old Password</Form.Label>
                  <Form.Control
                    type="password"
                    className="formInput"
                    value={oldPassword}
                    onChange={handleOldPasswordChange}
                  />
                </Form.Group>

                <Form.Group controlId="formNewPassword">
                  <Form.Label>New Password</Form.Label>
                  <Form.Control
                    type="text"
                    className="formInput"
                    value={newPassword}
                    onChange={handleNewPasswordChange}
                  />
                </Form.Group>

                <Form.Group controlId="formRetypeNewPassword">
                  <Form.Label>Retype New Password</Form.Label>
                  <Form.Control
                    type="password"
                    className="formInput"
                    value={retypeNewPassword}
                    onChange={handleRetypeNewPasswordChange}
                  />
                </Form.Group>

                <Button
                  variant="primary"
                  className="submitButton my-2"
                  type="submit"
                  disabled={!passwordsMatch || !oldAndNewDifferent}
                >
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

export default Resetpwd;
