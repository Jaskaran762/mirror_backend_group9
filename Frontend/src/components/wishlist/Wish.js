import React, { useState, useEffect } from "react";
import Footer from "../footer";
import HomeNavbar from "../HomeNav";
import { Card, Button, Row, Col } from "react-bootstrap";
import { useParams } from "react-router-dom";
import axios from "axios";

const Wish = () => {

  const token = sessionStorage.getItem("token");

  console.log(token);
  const headers = {
    Authorization: `Bearer ${token}`,
  };

  const [wishListDetails, setfetchedWishlist] = useState([]);

  useEffect(() => {

    axios.post("http://localhost:8090/home/wishlist", {}, { headers })
    .then((response) => {
       console.log("wishlist api response");
        console.log(response.data);
        setfetchedWishlist(response.data.wishLists);
      })
      .catch((error) => {
        console.error("Error fetching city details:", error);
      });
  }, []);

  return (
    <div>
      <HomeNavbar />
      <div>
        <h2>Wishlist</h2>
        {wishListDetails.map((item, index) => (
          <div key={index}>
            <h3>Wishlist Item {index + 1}</h3>
            <p>Wishlist ID: {item.wishListID}</p>
            <p>User ID: {item.userID}</p>
            {item.placeID && <p>Place ID: {item.placeID}</p>}
            {item.activityID && <p>Activity ID: {item.activityID}</p>}
            <p>City ID: {item.cityID}</p>
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
      <Footer />
    </div>
  );
};
export default Wish;