import React, { useState } from 'react'
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { RiHeartAddLine, RiHeartFill } from 'react-icons/ri';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';

const Landing = () => {

  const changePage = useNavigate();
  const handletrip = () => {
    changePage('/mainpage');
  }

  const [itinerary, setItinerary] = useState([]);
  const [wishlist, setWishlist] = useState([]);

  const handleAddToWishlist = (title) => {
    const itemIndex = wishlist.findIndex((item) => item.title === title);

    if (itemIndex !== -1) {
      const updatedWishlist = [...wishlist];
      updatedWishlist.splice(itemIndex, 1);
      setWishlist(updatedWishlist);
    } else {
      const item = {
        title: title,
      };
      setWishlist([...wishlist, item]);
    }
  };

  const isItemInWishlist = (title) => {
    return wishlist.some((item) => item.title === title);
  };

  const placesToVisit = [

    {
      title: 'Destination 1',
      content: 'Some content for tile 1.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
    {
      title: 'Destination 2',
      content: 'Some content for tile 1.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
    {
      title: 'Destination 3',
      content: 'Some content for tile 1.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
  ];

  const activitiesToTry = [
    {
      title: 'Activity 1',
      content: 'Some content for tile 1.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
    {
      title: 'Activity 2',
      content: 'Some content for tile 1.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
    {
      title: 'Activity 3',
      content: 'Some content for tile 1.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
  ];

  const renderCards = (data, type) => {
    const cards = data.map((item, index) => {
      const uniqueIndex = index + data.length * type;
      const isInWishlist = isItemInWishlist(item.title);
      return (

        <Col xs={12} md={6} lg={4} key={uniqueIndex}>
          <Card>
            <a href={item.link}>
              <Card.Img src={item.imgSrc} variant="top" />
            </a>
            <Card.Body>
              <Card.Title>{item.title}</Card.Title>
              <Card.Text>{item.content}</Card.Text>
              <Button variant="link" onClick={() => handleAddToWishlist(item.title)}>
                {isInWishlist ? <RiHeartFill size={30} /> : <RiHeartAddLine size={30} />}
              </Button>
            </Card.Body>
          </Card>
        </Col>
      );
    });
    
    return <Row>{cards}</Row>;
  };

  return (
    <div >
      <div style={{ marginTop: '0px' }}>
        <HomeNavbar />
      </div>
      <Button onClick={handletrip} style={{ marginTop: '2rem', marginLeft:'7rem', marginBottom:'2rem' }}>
        Start your trip
      </Button>
      {(
        <>
          <Container>
            <Row>
              <br />
              <Col>
                <div>
                  <h2 className="mb-3">Places to Visit</h2>
                </div>
              </Col>
            </Row>
            <Row>{renderCards(placesToVisit, 1)}</Row>
          </Container>
          <br />
          <Container>
            <Row>
              <br />
              <Col>
                <div>
                  <h2 className="mb-3">Activities to Try</h2>
                </div>
              </Col>
            </Row>
            <Row>{renderCards(activitiesToTry, 2)}</Row>
          </Container>
        </>
      )}
      <div style={{ marginTop: '10rem' }}>
        <Footer />
      </div>
    </div>
  )
}

export default Landing;