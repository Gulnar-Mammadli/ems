import './App.css'
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import AddEmployeeComponent from './components/AddEmployeeComponent';

function App() {

  return (
    <>
    <BrowserRouter>
        <HeaderComponent />
        <Routes>
          {/* http://localhost:3000 */}
          <Route path='/' element = {<ListEmployeeComponent/>}></Route>
          {/* http://localhost:3000/employees */}
          <Route path='/employees' element = {<ListEmployeeComponent/>}></Route>
          {/* http://localhost:3000/add-employee */}
          <Route path='/add-employee' element = {<AddEmployeeComponent/>}></Route>
          {/* http://localhost:3000/edit-employee/id */}
          <Route path='/edit-employee/:id' element = {<AddEmployeeComponent/>}></Route>
          {/* http://localhost:3000/delete-employee/id */}
          <Route path='/delete-employee/:id' element = {<AddEmployeeComponent/>}></Route> 
        </Routes>
        <FooterComponent /></BrowserRouter>     
    </>
  )
}

export default App
