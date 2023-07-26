import React, { useState, useEffect } from 'react'
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { RiHeartAddLine, RiHeartFill } from 'react-icons/ri';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import axios  from 'axios';

const Landing = () => {

  const changePage = useNavigate();
  const handletrip = () => {
    changePage('/mainpage');
  }

  const [itinerary, setItinerary] = useState([]);
  const [wishlist, setWishlist] = useState([]);
  const[placeList,setPlaceList] = useState([]);
  const[activityList,setActivityList] = useState([]);
  const[placeAPIList,setPlaceAPIList] = useState([]);
  //getplaces - based on user interest. This page will be different for user

  useEffect(() => {
    const token = sessionStorage.getItem('token');
    console.log(token);
    const headers = {
    Authorization: `Bearer ${token}`,
    };
    axios.post('http://localhost:8090/recommendation', { }, { headers })
    .then((response) => {
      console.log(response.data.placeResponseDTO);
      setPlaceList(response.data.placeResponseDTO);
    })
    .catch((error) => {
      console.error('Error fetching international regions:', error);
    });
  },[]);

  //getactivities - based on user interest. This page will be different for user

  useEffect(() => {
    const token = sessionStorage.getItem('token');
    console.log(token);
    const headers = {
    Authorization: `Bearer ${token}`,
    };
    axios.post('http://localhost:8090/recommendation', { }, { headers })
    .then((response) => {
      console.log(response.data.activityResponseDTO.activityObjectsResponseList);
      setActivityList(response.data.activityResponseDTO.activityObjectsResponseList);
    })
    .catch((error) => {
      console.error('Error fetching international regions:', error);
    });
  },[]);

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

  const getplaceList = (placeID) => {

    const token = sessionStorage.getItem('token');
    console.log(token);
    const headers = {
    Authorization: `Bearer ${token}`,
    };
    console.log(placeID);
   
    axios.post('http://localhost:8090/home/reviewplace', { placeid: placeID }, { headers })
      .then((response) => {
        console.log(response.data);
        console.log(response.data);
        setPlaceAPIList(response.data);
        //setPlaceToVisit(response.data.cities);
        console.log(JSON.stringify(response.data.reviewsPlaces[0].rating))
        console.log(placeAPIList);
        changePage('/place', {
          placeAPIList: response.data,
        });
        console.log(placeAPIList);
      })
      .catch((error) => {
        console.error('Error fetching domestic regions:', error);
      });

   // setSearchButton(true);

  };


  const renderCards = (placeList, type) => {
    const cards = placeList.map((item, index) => {
      const uniqueIndex = index + placeList.length * type;
      const isInWishlist = isItemInWishlist(item.title);
      return (

        <Col xs={12} md={6} lg={4} key={uniqueIndex}>
          <Card>
            <a href={item.link}>
              <Card.Img src={item.imgSrc} variant="top" />
            </a>
            <Card.Body>
              <Card.Title>
              <Button variant="link" onClick={() => getplaceList(item.placeID) }>
                {item.placeName} {item.activityName } 
              </Button>
              </Card.Title>
              <Card.Text>{item.description}</Card.Text>
              <Button variant="link" onClick={() => handleAddToWishlist(item.placeName) || handleAddToWishlist(item.activityName) }>
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
            <Row>{renderCards(placeList, 1)}</Row>
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
             <Row>{renderCards(activityList, 2)}</Row> 
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