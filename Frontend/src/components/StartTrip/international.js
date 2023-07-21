import React, { useState } from 'react';
import { Container, Row, Col, Button, Card, Modal, Form } from 'react-bootstrap';
import { RiHeartAddLine, RiHeartFill } from 'react-icons/ri';
import DateRangePicker from '../DateRangePicker';
import { useNavigate } from 'react-router-dom';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';

const International = () => {
  const [searchButton, setSearchButton] = useState(false);
  const [itemCounter, setItemCounter] = useState(0);

  const handleSearchButton = () => {
    setSearchButton(true);
  };

  const [showDialog, setShowDialog] = useState(false);
  const [selectedDate, setSelectedDate] = useState('');
  const [selectedTime, setSelectedTime] = useState('');
  const [selectedEndDate, setSelectedEndDate] = useState('');
  const [selectedEndTime, setSelectedEndTime] = useState('');
  const [itinerary, setItinerary] = useState([]);
  const [wishlist, setWishlist] = useState([]);

  const placesToVisit = [
    {
      title: 'Place 1',
      content: 'Some content for tile 1.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
    {
      title: 'Place 2',
      content: 'Some content for tile 2.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
    {
      title: 'Place 3',
      content: 'Some content for tile 3.',
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
      content: 'Some content for tile 2.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
    {
      title: 'Activity 3',
      content: 'Some content for tile 3.',
      imgSrc:
        'https://img.freepik.com/free-photo/top-view-travel-elements-collection_23-2148691085.jpg?w=996&t=st=1689391748~exp=1689392348~hmac=c616a095abb5a2edc3c0d43255c1c17d404f230c3c27999afa984d632df16ae6',
      link: 'http://www.example.com',
    },
  ];


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
    setItemCounter((prevCounter) => prevCounter + 1);
    setShowDialog(false);
    setSelectedDate('');
    setSelectedEndDate(''); 
    setSelectedTime('');
    setSelectedEndTime('');
  };


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

  const changePage = useNavigate();
  const handleItinerary = () => {
    console.log(itinerary);
    const pass = encodeURIComponent(JSON.stringify(itinerary));
    changePage('/itinerary/' + pass);
  };

  const handleWishlist = () => {
    const pass = encodeURIComponent(JSON.stringify(wishlist));
    changePage('/wish/' + pass);
  };

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
              <Button variant="primary" onClick={() => handleOpenDialog(uniqueIndex)}>
                Add to Itinerary
              </Button>
              <Button variant="link" onClick={() => handleAddToWishlist(item.title)}>
                {isInWishlist ? <RiHeartFill size={30} /> : <RiHeartAddLine size={30} />}
              </Button>
            </Card.Body>
          </Card>
          <Modal show={showDialog === uniqueIndex} onHide={handleCloseDialog}>
            <Modal.Header closeButton>
              <Modal.Title>Select Date and Time</Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <Form.Group>
                <Form.Label>Date</Form.Label>
                <Form.Control type="date" value={selectedDate} onChange={handleDateChange} />
              </Form.Group>
              <Form.Group>
                <Form.Label>Time</Form.Label>
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
              <Button variant="primary" onClick={() => handleSaveItinerary(item.title)}>
                Save
              </Button>
            </Modal.Footer>
          </Modal>
        </Col>
      );
    });

    return <Row>{cards}</Row>;
  };

  return (
    <>
      <br />
      <Container>
        <Row>
          <br />
          <Col>
            <div>
              <p className="mb-3">Select your travel date</p>
              <DateRangePicker style={{ height: '100px', width: '100px', fontSize: '1rem' }} />
            </div>
          </Col>
        </Row>
      </Container>
      <div className="text-left" style={{ padding: '15px' }}>
        <Button variant="primary" size="lg" onClick={handleSearchButton}>
          Search
        </Button>
      </div>
      {searchButton && (
        <>
          <Container>
          <Row>
          <Col>
            <Button onClick={handleWishlist}>WhishList</Button>
          </Col>
          <Col>
          <Button onClick={handleItinerary}>See Itinerary</Button>
          </Col>
        </Row>
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
    </>
  );
};

export default International;
