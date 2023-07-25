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
import ReviewsPage from "./components/reviews/review";
import Landing from "./components/Landing-page/landing";
import Resetpwd from "./components/UserProfile/Resetpwd";

import ThingsToCarry from "./components/ThingsToCarry/thingsToCarry";
import OTP from "./components/authentication/otp";
import ResetForgotPassword from "./components/authentication/resetForgotPassword";

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
        <Route path="/otp" element={<OTP />} />
        <Route path="/resetForgotPassword" element={<ResetForgotPassword />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/services" element={<ServicesPage />} />
        <Route path="/mainpage" element={<MainPage />} />
        <Route path = "/itinerary/:data" element ={<Auth><Itinerary/></Auth>}/>
        <Route path = "/wish/:data" element ={<Auth><Wish /></Auth>}/>
        <Route path = "/profile" element = {<Auth><UserProfile/></Auth>}/>
        <Route path = "/landing" element = {<Auth><Landing/></Auth>}/>
        <Route path ='/resetpassword' element = {<Auth><Resetpwd/></Auth>}/>
        <Route path = "/thingsToCarry" element = {<Auth><ThingsToCarry/></Auth>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
