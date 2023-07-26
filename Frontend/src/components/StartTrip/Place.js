import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';
import { RiHeartAddLine, RiHeartFill } from 'react-icons/ri';
import axios from 'axios';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';

const Place = () => {
  const [placeDetail, setPlaceDetail] = useState();
  const [showDialog, setShowDialog] = useState(false);
  const [selectedDate, setSelectedDate] = useState('');
  const [selectedTime, setSelectedTime] = useState('');
  const [selectedEndDate, setSelectedEndDate] = useState('');
  const [selectedEndTime, setSelectedEndTime] = useState('');
  const [itinerary, setItinerary] = useState([]);
  const [wishlist, setWishlist] = useState([]);
  
  const { placeID } = useParams();
  const token = sessionStorage.getItem('token');
  const headers = {
    Authorization: `Bearer ${token}`,
  };
  const placeIDAsNumber = parseInt(placeID, 10);

  useEffect(() => {
    axios
      .post('http://localhost:8090/home/place', { placeID: placeIDAsNumber }, { headers })
      .then((response) => {
        console.log(response.data);
        setPlaceDetail(response.data);
      })
      .catch((error) => {
        console.error('Error fetching place details:', error);
      });
  }, []);

  const handleOpenDialog = (index) => {
    setShowDialog(index);
  };

  const handleCloseDialog = () => {
    setShowDialog(false);
  };

  const handleDateChange = (event) => {
    setSelectedDate(event.target.value);
  };

  const handleTimeChange = (event) => {
    setSelectedTime(event.target.value);
  };

  const handleEndDateChange = (event) => {
    setSelectedEndDate(event.target.value);
  };

  const handleEndTimeChange = (event) => {
    setSelectedEndTime(event.target.value);
  };

  const handleSaveItinerary = (title) => {
    const item = {
      date: selectedDate,
      endDate: selectedEndDate,
      title: title,
      time: selectedTime,
      endTime: selectedEndTime,
    };
    setItinerary([...itinerary, item]);
    setShowDialog(false);
    setSelectedDate('');
    setSelectedEndDate('');
    setSelectedTime('');
    setSelectedEndTime('');
  };

  const handleAddToWishlist = (title) => {
    const itemIndex = wishlist.findIndex((item) => item.activityName === title);

    if (itemIndex !== -1) {
      const updatedWishlist = [...wishlist];
      updatedWishlist.splice(itemIndex, 1);
      setWishlist(updatedWishlist);
    } else {
      const item = {
        activityName: title,
      };
      setWishlist([...wishlist, item]);
    }
  };

  const isItemInWishlist = (title) => {
    return wishlist.some((item) => item.activityName === title);
  };

  const renderActivityCards = () => {
    if (!placeDetail || !placeDetail.activityObjectsResponseList) {
      return <div>Loading...</div>;
    }

    return placeDetail.activityObjectsResponseList.map((activity, index) => {
      const uniqueIndex = index;

      const isInWishlist = isItemInWishlist(activity.activityName);

      return (
        <Col xs={12} md={6} lg={4} key={uniqueIndex}>
          <Card>
            {activity.activityImageLink && <Card.Img variant="top" src={activity.activityImageLink} />}
            <Card.Body>
              <Card.Title>{activity.activityName}</Card.Title>
              <Card.Text>{activity.description}</Card.Text>
            </Card.Body>
            <Card.Footer>
              <Button variant="primary" onClick={() => handleOpenDialog(uniqueIndex)}>
                Add to Itinerary
              </Button>
              <Button variant="link" onClick={() => handleAddToWishlist(activity.activityName)}>
                {isInWishlist ? <RiHeartFill size={30} /> : <RiHeartAddLine size={30} />}
              </Button>
            </Card.Footer>
          </Card>
          <Modal show={showDialog === uniqueIndex} onHide={handleCloseDialog}>
            <Modal.Header closeButton>
              <Modal.Title>Select Date and Time</Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <Form.Group>
                <Form.Label>Start Date</Form.Label>
                <Form.Control type="date" value={selectedDate} onChange={handleDateChange} />
              </Form.Group>
              <Form.Group>
                <Form.Label>Start Time</Form.Label>
                <Form.Control type="time" value={selectedTime} onChange={handleTimeChange} />
              </Form.Group>
              <Form.Group>
                <Form.Label>End Date</Form.Label>
                <Form.Control type="date" value={selectedEndDate} onChange={handleEndDateChange} />
              </Form.Group>
              <Form.Group>
                <Form.Label>End Time</Form.Label>
                <Form.Control type="time" value={selectedEndTime} onChange={handleEndTimeChange} />
              </Form.Group>
            </Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" onClick={handleCloseDialog}>
                Cancel
              </Button>
              <Button variant="primary" onClick={() => handleSaveItinerary(activity.title)}>
                Save
              </Button>
            </Modal.Footer>
          </Modal>
  
        </Col>
      );
    });
  };

  return (
    <>
      <HomeNavbar />
      <Container>
        <Row>
          <Col>
            {placeDetail && (
              <>
                <h1>{placeDetail.placeName}</h1>
                <p>{placeDetail.description}</p>
              </>
            )}
          </Col>
        </Row>
        <Row>
          <h2>Activities to Enjoy</h2>
        </Row>
        <Row>{renderActivityCards()}</Row>
      </Container>
      <Footer />
    </>
  );
};

export default Place;
