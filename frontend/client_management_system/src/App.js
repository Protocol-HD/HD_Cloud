import './App.css';
import NavBar from "./components/NavBar";
import AddClient from "./components/AddClient";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import ListClient from "./components/ListClient";
import FileManagement from "./components/FileManagement";
import Main from "./components/Main";

function App() {
    return (
        <BrowserRouter>
            <NavBar/>
            <Routes>
                <Route path="/" element={<Main/>}/>
                <Route path="/add" element={<AddClient/>}/>
                <Route path="/list" element={<ListClient/>}/>
                <Route path="/fileManagement" element={<FileManagement/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
