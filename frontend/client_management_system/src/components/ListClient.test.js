import React from "react";
import {render, screen} from "@testing-library/react";
import ListClient from "./ListClient";

test("ListClient 컴포넌트 테스트", () => {
    render(<ListClient/>);
    const title = screen.getByText("Client List");
    expect(title).toBeInTheDocument();
    const table = screen.getByText("No");
    expect(table).toBeInTheDocument();
})

