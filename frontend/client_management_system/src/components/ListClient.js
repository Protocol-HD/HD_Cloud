import React, {Fragment, useEffect, useState} from 'react';
import axios from "axios";
import Title from "./Title";

function ListClient() {
    const findAllClientUrl = "/api/findAllClient";
    const editClientUrl = "/api/editClient";
    const deleteClientUrl = "/api/deleteClient/";
    const searchClientUrl = "/api/searchClient/"
    const [clients, setClients] = useState([]);

    useEffect(() => {
        axios.get(findAllClientUrl).then(res => setClients(res.data));
    }, []);

    const edit = (client) => {
        document.getElementById(`clientRow${client.id}`).className = "hide";
        document.getElementById(`clientEditRow${client.id}`).className = "";
        document.getElementById(`clientName${client.id}`).value = client.clientName;
        document.getElementById(`gender${client.id}`).value = client.gender;
        document.getElementById(`email${client.id}`).value = client.email;
        document.getElementById(`birthYear${client.id}`).value = client.birthYear;
    }

    const commit = (client) => {
        axios.put(editClientUrl, {
            id: client.id,
            clientName: document.getElementById(`clientName${client.id}`).value,
            gender: document.getElementById(`gender${client.id}`).value,
            email: document.getElementById(`email${client.id}`).value,
            birthYear: document.getElementById(`birthYear${client.id}`).value
        }).then(res => {
            setClients(
                clients.slice(0, clients.findIndex(cl => cl.id === client.id))
                    .concat([res.data])
                    .concat(
                        clients.slice(clients.findIndex(cl => cl.id === client.id) + 1, clients.length)
                    )
            )
        }).then(() => {
            document.getElementById(`clientRow${client.id}`).className = "";
            document.getElementById(`clientEditRow${client.id}`).className = "hide";
        });
    }

    const del = (id) => {
        if (window.confirm("정말 삭제하시겠습니까?")) {
            axios.delete(deleteClientUrl + id)
                .then(() => {
                    setClients(
                        clients.slice(0, clients.findIndex(cl => cl.id === id))
                            .concat(
                                clients.slice(clients.findIndex(cl => cl.id === id) + 1, clients.length)
                            )
                    )
                })
        }
    }

    const cancel = (id) => {
        document.getElementById(`clientRow${id}`).className = "";
        document.getElementById(`clientEditRow${id}`).className = "hide";
    }

    const search = () => {
        if (document.getElementById("search").value !== "") {
            axios.get(searchClientUrl + document.getElementById("search").value)
                .then(res => setClients(res.data));
        } else {
            axios.get(findAllClientUrl).then(res => setClients(res.data.slice(0, 100)));
        }
    }

    const enterKey = (e) => {
        if (e.key === 'Enter') search();
    }

    return (
        <>
            <Title src={"./images/List_client.svg"} title={"Client List"}/>

            <div className="container">
                <div className="searchBox">
                    <input id="search" className="searchInput" placeholder="검색할 키워드 입력 (이름 or 이메일)" onKeyUp={enterKey}/>
                    <button className="searchButton" onClick={search}>Search</button>
                </div>

                <table className="clientTable">
                    <thead>
                    <tr>
                        <th className="tableNo">No</th>
                        <td className="tableName">이름</td>
                        <td className="tableGender">성별</td>
                        <td className="tableEmail">이메일</td>
                        <td className="tableYear">출생년도</td>
                        <td className="tableButton">관리</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        clients.map((client, index) => (
                            <Fragment key={index}>
                                <tr id={`clientRow${client.id}`}>
                                    <th>{index + 1}</th>
                                    <td>{client.clientName}</td>
                                    <td>{client.gender}</td>
                                    <td>{client.email}</td>
                                    <td>{client.birthYear}</td>
                                    <td className="tableButton">
                                        <button className="editButton" onClick={() => edit(client)}>수정</button>
                                        <button className="deleteButton" onClick={() => del(client.id)}>삭제</button>
                                    </td>
                                </tr>

                                <tr className="hide" id={`clientEditRow${client.id}`}>
                                    <th>{index + 1}</th>
                                    <td>
                                        <input type="text" className="editInputBox" id={`clientName${client.id}`}/>
                                    </td>
                                    <td>
                                        <select className="editInputBox" id={`gender${client.id}`}>
                                            <option value="M">남자</option>
                                            <option value="F">여자</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="text" className="editInputBox" id={`email${client.id}`}/>
                                    </td>
                                    <td>
                                        <input type="number" className="editInputBox" id={`birthYear${client.id}`}/>
                                    </td>
                                    <td className="tableButton">
                                        <button className="editButton" onClick={() => commit(client)}>저장</button>
                                        <button className="deleteButton" onClick={() => cancel(client.id)}>취소</button>
                                    </td>
                                </tr>
                            </Fragment>
                        ))
                    }
                    </tbody>
                </table>
            </div>
        </>
    );
}

export default ListClient;