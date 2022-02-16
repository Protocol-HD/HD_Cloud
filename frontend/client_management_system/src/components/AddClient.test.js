import React from "react";
import {fireEvent, render, screen} from "@testing-library/react";
import AddClient from "./AddClient";

test("AddClient 컴포넌트 테스트", () => {
    render(<AddClient/>);
    const title = screen.getByText("Add Client");
    expect(title).toBeInTheDocument();
    const inputName = screen.getByPlaceholderText("ex) 홍길동")
    expect(inputName).toBeInTheDocument();
    const inputGender = screen.getByText("선택하세요");
    expect(inputGender).toBeInTheDocument();
    const inputEmail = screen.getByPlaceholderText("ex) example@gmail.com")
    expect(inputEmail).toBeInTheDocument();
    const inputBrith = screen.getByPlaceholderText("ex) 1991");
    expect(inputBrith).toBeInTheDocument();
    const addButton = screen.getByText("등록하기");
    expect(addButton).toBeInTheDocument();
})