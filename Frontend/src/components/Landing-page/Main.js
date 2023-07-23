import React, { useState } from 'react';
import { Container, Row, Col, Form} from 'react-bootstrap';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import International from '../StartTrip/international';
import Domestic from '../StartTrip/domestic';

const MainPage = () => {
  const [destinationType, setDestinationType] = useState('International');

  const handleDestinationTypeChange = (event) => {
    setDestinationType(event.target.value);
  };

  const[selectState,setselectState] = useState('Kerala');
  const handleChangeState = (event) => {
    setselectState(event.target.value);
  }

  const[selectCity,setselectCity] = useState('Ahmedabad');
  const handleChangeCity = (event) => {
    setselectState(event.target.value);
  }

  const[selectCountry,setselectCountry] = useState('USA');
  const handleChangeCountry = (event) => {
    setselectCountry(event.target.value);
  }

  return (
    <div
      style={{
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        minHeight: '125vh',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
      }}
    >
      <HomeNavbar />

      <Container>
        <Row className="my-4">
          <Col>
            <div className="text-center">
              <h1 style={{ color: 'ActiveCaption' }}>Where do you want to go?</h1>
            </div>
            <div className="d-flex justify-content-center mt-4">
              <Form>
                <Form.Group>
                  <div className="d-flex justify-content-center">
                    <Form.Check
                      type="radio"
                      label="International"
                      name="destinationType"
                      value="International"
                      checked={destinationType === 'International'}
                      onChange={handleDestinationTypeChange}
                      style={{ marginRight: '20px' }}
                    />
                    <Form.Check
                      type="radio"
                      label="Domestic"
                      name="destinationType"
                      value="National"
                      checked={destinationType === 'National'}
                      onChange={handleDestinationTypeChange}
                    />
                  </div>
                </Form.Group>
          
            {destinationType === 'National' && (
              <div>
                <Form.Group controlId="formStateChange">
                   <Form.Label> Which state you want to go </Form.Label>
                  <Form.Control as="select" value={selectState} onChange={handleChangeState} >         
                    <option value="West Bengal">West Bengal</option>
                    <option value="Maharashtra">Maharashtra</option>
                    <option value="Madhya Pradesh">Madhya Pradesh</option>
                    <option value="Kerala">Kerala</option>
                    <option value="Orissa">Orissa</option>
                    <option value="Kashmir">Kashmir</option>
                  </Form.Control>
               </Form.Group>
               </div>
            )}

        {destinationType === 'International' && (
              <div>
                 <Form.Group controlId="formCountryChange">
                   <Form.Label> Country</Form.Label>
                  <Form.Control as="select" value={selectCountry} onChange={handleChangeCountry} >         
                    <option value="Canada">Canada</option>
                    <option value="USA">USA</option>
                    <option value="India">India</option>
                    <option value="London">London</option>
                    <option value="France">France</option>
                    <option value="Paris">Paris</option>
                  </Form.Control>
             </Form.Group>
               </div>
            )}
               <br></br>
               <div>
                <Form.Group controlId="formCityChange">
                   <Form.Label> Which city you want to go </Form.Label>
                  <Form.Control as="select" value={selectCity} onChange={handleChangeCity} >         
                    <option value="West Bengal">West Bengal</option>
                    <option value="Maharashtra">Maharashtra</option>
                    <option value="Madhya Pradesh">Madhya Pradesh</option>
                    <option value="Kerala">Kerala</option>
                    <option value="Orissa">Orissa</option>
                    <option value="Kashmir">Kashmir</option>
                  </Form.Control>
               </Form.Group>
               </div>
               {destinationType === 'National' && <Domestic/> }
               {destinationType === 'International' && <International/> }
               
              </Form>
            </div>
          </Col>
        </Row>
      </Container>

      <Footer />
    </div>
  );
};

export default MainPage;
