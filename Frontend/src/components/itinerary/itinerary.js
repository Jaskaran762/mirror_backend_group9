import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'react-big-calendar/lib/css/react-big-calendar.css';
import { useParams } from 'react-router-dom';
import HomeNavbar from '../HomeNav';
import Footer from '../footer';
import { Button } from 'react-bootstrap';

const localizer = momentLocalizer(moment);

const Itinerary = () => {
 // const { data } = useParams();
//  console.log("==========>"+data);
 // console.log("*********"+decodeURIComponent(data) );
//  const itinerary = JSON.parse(decodeURIComponent(data));
  //console.log(itinerary);
debugger;
  const [userItinerary, setUserItinerary] = useState([]);

  useEffect(() => {
    // Fetch the itinerary data from the backend using the API
    const token = sessionStorage.getItem('token');
    const headers = {
      Authorization: `Bearer ${token}`,
    };

    const requestBody = { };

    axios.post('http://localhost:8091/home/itinerary',requestBody ,{ headers })
      .then((response) => {
        console.log('User itinerary:', response.data.itineraryObjectList);
        // Save the fetched itinerary data to the state
        setUserItinerary(response.data.itineraryObjectList);
      })
      .catch((error) => {
        console.error('Error fetching user itinerary:', error);
        // Handle error here if needed
      });
  }, []);

  const formattedEvents = userItinerary.map((item) => {
    return {
      id: item.itineraryid,
      title: `Itinerary ${item.itineraryid}`, // You can customize the title if needed
      start: new Date(item.startdate),
      end: new Date(item.endDate),
      allDay: true, // Set to true if the event lasts for the whole day
    };
  });

  /*const formattedEvents = itinerary.map((item, index) => {
    const startDateTime = moment(`${item.date} ${item.time}`, 'YYYY-MM-DD HH:mm').toDate();
    const endDateTime = moment(`${item.endDate} ${item.endTime}`, 'YYYY-MM-DD HH:mm').toDate(); */

   /* return {
      id: index,
      title: item.title,
      start: startDateTime,
      end: endDateTime,
      allDay: false,
    };
  }); */


  return (
    <>
      <HomeNavbar />
      <div style={{ height: '500px', padding: '20px' }}>
        <h2>Itinerary</h2>
        {<Calendar
          localizer={localizer}
          events={formattedEvents}
          startAccessor="start"
          endAccessor="end"
          defaultView="month"
          views={[ 'month']}
          step={60}
          showMultiDayTimes
          defaultDate={new Date()}
          
          min={new Date(null, null, null, 0)} 
          max={new Date(null, null, null, 22)}
        /> }
      </div>
      <Button style={{marginLeft:'85rem', marginTop:'2rem', height:'1cm', width:'3cm'}}>
        Save
      </Button>
      <div style={{ marginTop: '5rem' }}>
        <Footer />
      </div>
    </>
  );
};

export default Itinerary;
