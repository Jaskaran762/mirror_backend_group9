import "./App.css";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Login from "./components/authentication/Login";
import Home from "./components/Home";
import Signup from "./components/authentication/Signup";
import Error from "./components/Error";
import ForgotPassword from "./components/authentication/forgot";
import ContactPage from "./components/HomeNavOptions/Contact";
import ServicesPage from "./components/HomeNavOptions/Services";
import AboutPage from "./components/HomeNavOptions/About";
import MainPage from "./components/Landing-page/Main";

import "bootstrap/dist/css/bootstrap.css";
import Itinerary from "./components/itinerary/itinerary";
import Wish from "./components/wishlist/Wish";
import UserProfile from "./components/UserProfile/profile";
<<<<<<< HEAD
import ReviewsPage from "./components/reviews/review";
=======
import Landing from "./components/Landing-page/landing";
>>>>>>> 7bfe193f7bde6edc59c6c8fb3e8b4f1ae6348a14

export function isLoggedIn() {
  const token = localStorage.getItem("token");
  return token !== null;
}

export function Auth({ children }) {
  return isLoggedIn() ? children : null;
}
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/forgot-password" element={<ForgotPassword />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/services" element={<ServicesPage />} />
        <Route path="/mainpage" element={<MainPage />} />
        <Route path = "/itinerary/:data" element ={<Itinerary/>}/>
<<<<<<< HEAD
        <Route path = "/wish/:data" element ={<Wish />}/>
        <Route path = "/reviews/:data" element ={<ReviewsPage />}/>
        <Route path = "/profile" element = {<UserProfile/>}/>
=======
        <Route path = "/wish/:data" element ={<Auth><Wish /></Auth>}/>
        <Route path = "/profile" element = {<Auth><UserProfile/></Auth>}/>
        <Route path = "/landing" element = {<Auth><Landing/></Auth>}/>
>>>>>>> 7bfe193f7bde6edc59c6c8fb3e8b4f1ae6348a14
      </Routes>
    </BrowserRouter>
  );
}

export default App;
