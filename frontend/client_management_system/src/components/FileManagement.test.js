import React from "react";
import {render, screen} from "@testing-library/react";
import FileManagement from "./FileManagement";

test("FileManagement 컴포넌트 테스트", () => {
    render(<FileManagement/>);
    const addClient = screen.getByText("File Management");
    expect(addClient).toBeInTheDocument();
    const uploadButton = screen.getByText("UPLOAD");
    expect(uploadButton).toBeInTheDocument();
})

