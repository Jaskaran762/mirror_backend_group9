import React, { useState, useEffect }  from 'react';
import { useParams } from 'react-router-dom';
import axios  from 'axios';

const PlacePage = () => {
   const { placeID }  = useParams();
   const [placeDetail,setplaceDetail] = useState();
   const [reviewDetail, setreviewDetail ] = useState([]);
   const token = sessionStorage.getItem('token');
   const headers = {
   Authorization: `Bearer ${token}`,
   };
   const placeIDNum= parseInt(placeID, 10);
    console.log(placeIDNum);
    useEffect(()=>{
        axios.post('http://localhost:8090/home/place', { placeID:placeIDNum }, { headers })
        .then((response) => {
            console.log(response.data);
            setplaceDetail(response.data);
            console.log(placeDetail);
          })
          .catch((error) => {
            console.error('Error fetching domestic regions:', error);
          });
    
        },[])
          useEffect(()=>{
            axios.post('http://localhost:8090/home/reviewplace', { placeid:placeIDNum }, { headers })
            .then((response) => {
                console.log(response.data.reviewsPlaces);
                setreviewDetail(response.data.reviewsPlaces);
              })
              .catch((error) => {
                console.error('Error fetching domestic regions:', error);
              });
        
            },[])
            useEffect(() => {
                console.log(placeDetail); // Log placeDetail when it gets updated
              }, [placeDetail]);
            useEffect(() => {
                console.log(reviewDetail); // Log placeDetail when it gets updated
              }, [reviewDetail]);
       
              if (!placeDetail) {
                return <div>Loading...</div>;
              }
              if (!reviewDetail) {
                return <div>Loading..reviews</div>;
              }
            
   // Now you can use the fetched placeList and activityList data here
    return (
      <div>
        <p> abc</p>
       
       <p>{ placeDetail.placeName } </p> 
      <p>{ placeDetail.description } </p> 
      <img src={ placeDetail.placeImageLink }></img> 

      {reviewDetail.map((review) => (
                       <div key={review.reviewPlaceID}>
                       <p>Rating: {review.rating}</p>
                       <p>Comment: {review.reviewplaceComment}</p>
                       <p> DateofReview : { review.dateofreview } </p>
                       {/* Render other review details as needed */}
                     </div>
                      ))}
      </div>
    );
  };
  
  export default PlacePage;