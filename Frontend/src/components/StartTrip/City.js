import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';

import axios from 'axios';

const City = () => {
    const [cityDetail,setCityDetail] = useState();
    
    const {cityID}=useParams();
    const token = sessionStorage.getItem('token');
    const headers = {
    Authorization: `Bearer ${token}`,
    };
    const cityIDAsNumber = parseInt(cityID, 10);
    console.log(cityIDAsNumber);
    useEffect(()=>{
    axios.post('http://localhost:8091/home/city', { cityID:cityIDAsNumber}, { headers })
      .then((response) => {
        console.log(response.data);
        setCityDetail(response.data);
      })
      .catch((error) => {
        console.error('Error fetching domestic regions:', error);
      });

    },[])

    const renderCards = (data, type) => {
      const cards = data.map((item, index) => {
        const uniqueIndex = index + data.length * type;
          return(
            <Col xs={12} md={6} lg={4} key={uniqueIndex}>
            <Card>
            <Card.Body>
              <Card.Title>
                {item.cityName}
              </Card.Title>
              <Card.Text>{item.description}</Card.Text>
              </Card.Body>
              </Card>
            </Col>
          );
    });
    };
   

  return (
    <div>

    </div>
  )
  }

export default City 