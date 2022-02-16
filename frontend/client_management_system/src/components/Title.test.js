import React from "react";
import {render, screen} from "@testing-library/react";
import Title from "./Title";

test("Title 컴포넌트 테스트", () => {
    render(<Title src={"test.jpg"} title={"title test"}/>);
    const title = screen.getByText("title test");
    expect(title).toBeInTheDocument();
    const titleImg = screen.getByAltText("title test")
    expect(titleImg).toHaveAttribute("src", "test.jpg");
})