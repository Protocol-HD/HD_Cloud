import React, {useEffect, useState} from 'react';
import Title from "./Title";
import axios from "axios";

function FileManagement() {
    const findAllFileDataUrl = "/api/findAllFileData";
    const fileDataDownloadUrl = "/api/download/"
    const [files, setFiles] = useState([]);

    useEffect(() => {
        axios.get(findAllFileDataUrl).then(res => {
            setFiles(res.data);
        })
    }, [])

    const upload = () => {
        if (document.getElementById("uploadFile").files.length) {
            const formData = new FormData();
            formData.append("file", document.getElementById("uploadFile").files[0]);
            axios.post("/api/upload", formData)
                .then(res => {
                    document.getElementById("uploadFile").value = "";
                    alert("업로드 완료!");
                    setFiles(files.concat([res.data]));
                });
        }

    }

    return (
        <>
            <Title src={"./images/upload.svg"} title={"File Management"}/>

            <div className="cardBox">
                <div className="inputLabel">
                    업로드할 파일 선택 (파일당 20MB 제한)
                </div>
                <input id="uploadFile" className="inputBox" type="file"/>
                <button className="submitButton" onClick={upload}>UPLOAD</button>
            </div>

            <div className="container">
                <div className="fileCardBox">
                    {
                        files && files.map(file => (
                            <div key={file.id} className="fileCard">
                                <p className="fileExt">{file.fileName.split('.')[file.fileName.split('.').length - 1]}</p>
                                <p className="fileName">{file.fileName}</p>
                                <a href={fileDataDownloadUrl + file.id}>
                                    <button className="downloadButton">Download</button>
                                </a>
                            </div>
                        ))
                    }
                </div>
            </div>
        </>
    );
}

export default FileManagement;
