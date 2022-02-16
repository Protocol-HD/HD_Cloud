import React from 'react';

function Title({src, title}) {
    return (
        <div className="logoBox">
            <img src={src} alt={title}/>
            <h2 className="title">{title}</h2>
        </div>
    );
}

export default Title;
