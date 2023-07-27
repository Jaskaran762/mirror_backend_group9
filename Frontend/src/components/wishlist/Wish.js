import React, { useState } from 'react';
import Footer from '../footer';
import HomeNavbar from '../HomeNav';

import { Card, Button, Row, Col } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import { RiDeleteBinLine } from 'react-icons/ri';

const Wish = () => {
  const { data } = useParams();
  const wishlist = JSON.parse(decodeURIComponent(data));

  const [updatedWishlist, setUpdatedWishlist] = useState(wishlist);

  const handleDeleteItem = (index) => {
    const newWishlist = [...updatedWishlist];
    newWishlist.splice(index, 1);
    setUpdatedWishlist(newWishlist);
  };

  return (
    <div
      style={{
        minHeight: '100vh', 
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
      }}
    >
      <HomeNavbar />
      <div style={{ padding: '20px' }}>
        <h2>Wishlist</h2>
        {wishlist.map((item, index) => (
       
          
          <Card key={index} style={{ marginBottom: '10px' }}>
            <Card.Body>
            <Row>
            <Col>
              <Card.Title>{item.title}</Card.Title>
              </Col>
              <Col>
              <button
                onClick={() => handleDeleteItem(index)}
                style={{
                  cursor: 'pointer',
                  color: 'blue',
                  marginLeft:'50rem'
                }}
              >
                <RiDeleteBinLine size={20} />
              </button>
              </Col>
              </Row>
            </Card.Body>
          </Card>
  
        ))}
      </div>
      <Footer />
    </div>
  );
};

export default Wish;
