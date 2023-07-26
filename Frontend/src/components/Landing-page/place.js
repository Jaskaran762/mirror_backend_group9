import React from 'react';
import { useLocation } from 'react-router-dom';


const PlacePage = (props) => {
    const location = useLocation();
  const { placeAPIList } = location.state;
    // Now you can use the fetched placeList and activityList data here
  
    return (
      <div>
       {placeAPIList.map((place) => (
        <div key={place.placeID}>
          <h3>{place.placeID}</h3>
          <p>{place.rating}</p>
          {/* Render other details as needed */}
        </div>
      ))}
      </div>
    );
  };
  
  export default PlacePage;