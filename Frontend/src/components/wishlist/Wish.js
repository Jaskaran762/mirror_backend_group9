import React from 'react';
import Footer from '../footer';
import HomeNavbar from '../HomeNav';

import { Card, Button } from 'react-bootstrap';
import { useParams } from 'react-router-dom';

const Wish = () => {
  const { data } = useParams();
  const wishlist = JSON.parse(decodeURIComponent(data));

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
              <Card.Title>{item.title}</Card.Title>
            </Card.Body>
          </Card>
        ))}
      </div>
      <Footer />
    </div>
  );
};

export default Wish;
