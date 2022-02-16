import React, {useState} from 'react';
import axios from "axios";
import Title from "./Title";

function AddClient() {
    const addClientUrl = "/api/addClient";
    const [errorGender, setErrorGender] = useState(false);
    const [errorName, setErrorName] = useState(false);
    const [errorEmail, setErrorEmail] = useState(false);
    const [errorBrithYear, setErrorBrithYear] = useState(false);


    const addClient = () => {
        setErrorName(false);
        setErrorGender(false);
        setErrorEmail(false);
        setErrorBrithYear(false);

        let year = new Date().getFullYear()

        if (document.getElementById("clientName").value === "") {
            setErrorName(true);
        } else if (document.getElementById("gender").value === "") {
            setErrorGender(true);
        } else if (document.getElementById("email").value === "" || !document.getElementById("email").value.includes('@')) {
            setErrorEmail(true);
        } else if (document.getElementById("birthYear").value > year || document.getElementById("birthYear").value < year - 120) {
            setErrorBrithYear(true);
        } else {
            axios.post(addClientUrl, {
                clientName: document.getElementById("clientName").value,
                gender: document.getElementById("gender").value,
                email: document.getElementById("email").value,
                birthYear: document.getElementById("birthYear").value
            }).then(() => {
                document.getElementById("clientName").value = "";
                document.getElementById("gender").value = "";
                document.getElementById("email").value = "";
                document.getElementById("birthYear").value = "";
            }).then(() => {
                alert("등록이 성공하였습니다.")
            });
        }
    }

    return (
        <>
            <Title src={"./images/Add_client.svg"} title={"Add Client"}/>

            <div className="cardBox">
                <div className="inputLabel">
                    이름
                    <span className={errorName ? "inputAlert" : "hide"}>
                        이름을 입력하세요
                    </span>
                </div>
                <input id="clientName" className="inputBox" type="text" placeholder="ex) 홍길동"/>

                <div className="inputLabel">
                    성별
                    <span className={errorGender ? "inputAlert" : "hide"}>
                        성별을 선택하세요
                    </span>
                </div>
                <select id="gender" className="inputBox">
                    <option value="">선택하세요</option>
                    <option value="M">남자</option>
                    <option value="F">여자</option>
                </select>

                <div className="inputLabel">
                    이메일
                    <span className={errorEmail ? "inputAlert" : "hide"}>
                        유효한 이메일을 입력하세요
                    </span>
                </div>
                <input id="email" className="inputBox" type="email" placeholder="ex) example@gmail.com"/>

                <div className="inputLabel">
                    출생년도
                    <span className={errorBrithYear ? "inputAlert" : "hide"}>
                        유효한 출생년도를 입력하세요
                    </span>
                </div>
                <input id="birthYear" className="inputBox" type="number" placeholder="ex) 1991"/>

                <button className="submitButton" onClick={addClient}>등록하기</button>
            </div>
        </>
    );
}

export default AddClient;