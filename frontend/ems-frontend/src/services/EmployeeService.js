import axios from 'axios';

const BASE_URL = "http://localhost:8080/api/employees";

export const listEmployees = ()=>{
    return axios.get(BASE_URL);
}

export const addNewEmployee = (employee)=>{
    return axios.post(BASE_URL,employee);
}

export const updateExistingEmployee = (employee)=>{
    return axios.patch(BASE_URL,employee);
}


export const deleteEmployee = (employeeId)=>{
    return axios.delete(BASE_URL+"/"+employeeId,employeeId);
}