import React, { useState, useEffect } from 'react';
import Footer from '../footer';
import HomeNavbar from '../HomeNav';

import { Card, Button, Row, Col } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import { RiDeleteBinLine } from 'react-icons/ri';
import axios from 'axios';

const Wish = () => {
  /*  const { data } = useParams();
   const wishlist = JSON.parse(decodeURIComponent(data));

  const [updatedWishlist, setUpdatedWishlist] = useState(wishlist); */
  
  /* const handleDeleteItem = (index) => {
    const newWishlist = [...updatedWishlist];
    newWishlist.splice(index, 1);
    //setUpdatedWishlist(newWishlist);
  };  */
  const [wishListDetails, setWishListDetails] = useState([]);

 const [fetchWishlist, setfetchedWishlist] = useState([]);
 const [fetchplaceDetail, setplaceDetail] = useState([]);
 const [fetchactivityDetail, setactivityDetail] = useState([]);
 
 /* new code */
 useEffect(() => {
  const token = sessionStorage.getItem('token');
  const headers = {
    Authorization: `Bearer ${token}`,
  };

  const fetchDetails = async () => {
    const promises = fetchWishlist.map((item) => {
      if (item.placeID) {
        return axios.post('http://localhost:8090/home/place', { placeID: item.placeID }, { headers });
      } else if (item.activityID) {
        return axios.post('http://localhost:8090/home/activities', { activityID: item.activityID }, { headers });
      } else {
        return null;
      }
    });

    try {
      const responses = await Promise.all(promises);
      const details = responses.map((response, index) => {
        const detail = response ? response.data : null;
        return {
          ...fetchWishlist[index],
          detail,
        };
      });
      setWishListDetails(details);
    } catch (error) {
      console.error('Error fetching details:', error);
    }
  };

  fetchDetails();
}, [fetchWishlist]);

 
 /* new code */


  useEffect(() => {

  const token = sessionStorage.getItem('token');
  const headers = {
    Authorization: `Bearer ${token}`,
  };
    axios
      .post('http://localhost:8090/home/wishlist', {}, { headers })
      .then((response) => {
        console.log("wishlist api response");
        console.log(response.data);
        setfetchedWishlist(response.data.wishLists);
      })
      .catch((error) => {
        console.error('Error fetching city details:', error);
      });
  }, []);

  useEffect(()=>{

  const token = sessionStorage.getItem('token');
  console.log(token);
  const headers = {
    Authorization: `Bearer ${token}`,
  }; 


    axios.post('http://localhost:8090/home/place', { placeID:3 }, { headers })
    .then((response) => {
        console.log(response.data);
        setplaceDetail(response.data);
      })
      .catch((error) => {
        console.error('Error fetching place regions:', error);
      });

    },[])

    useEffect(()=>{

      const token = sessionStorage.getItem('token');
      console.log(token);
      const headers = {
        Authorization: `Bearer ${token}`,
      };
        axios.post('http://localhost:8090/home/activities', { activityID:1}, { headers })
        .then((response) => {
            console.log(response.data);
            setactivityDetail(response.data);
          })
          .catch((error) => {
            console.error('Error fetching place regions:', error);
          });
    
        },[])

  /*return (
    <div>
    <div>
      <h2>Wishlist</h2>
      {fetchWishlist.map((item, index) => (
        <div key={index}>
          <h3>Wishlist Item {index + 1}</h3>
          <p>Wishlist ID: {item.wishListID}</p>
          <p>User ID: {item.userID}</p>
          <p>Place ID: {item.placeID}</p>
          <p>Activity ID: {item.activityID}</p>
          <p>City ID: {item.cityID}</p>
        </div>
      ))}
    </div>

    <div>
      {fetchplaceDetail.placeName}
      {fetchactivityDetail.activityName}
    </div>
</div> */



return (
  <div>
    <div>
      <h2>Wishlist</h2>
      {wishListDetails.map((item, index) => (
        <div key={index}>
          <h3>Wishlist Item {index + 1}</h3>
         {/* <p>Wishlist ID: {item.wishListID}</p> */}
      {/* <p>User ID: {item.userID}</p> */}
      {/* {item.placeID && <p>Place ID: {item.placeID}</p>} */}
      {/* {item.activityID && <p>Activity ID: {item.activityID}</p>} */}
      {/* <p>City ID: {item.cityID}</p> */}
          {item.detail && (
            <div>
              {item.detail.placeName}
              {item.detail.activityName}
              {/* Display other details fetched from the API */}
            </div>
          )}
        </div>
      ))}
    </div>
  </div>
);
          };
export default Wish;

