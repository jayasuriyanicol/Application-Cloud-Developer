import React, { useEffect, useState } from 'react';

const url = "https://jsonplaceholder.typicode.com/photos";

const FetchComponents = () => {
    const [photos, setPhotos] = useState([]);

    const getData = async () => {
        const data = await fetch(url).then(res => res.json());
        setPhotos(data);
    };

    useEffect(() => {
        getData();
    }, []);

    return (
        <>
            <h1>FetchComponents</h1>
            <ul className="users">
                {photos.slice(0, 10).map((el) => {
                    const { title, id, thumbnailUrl: img, url } = el;
                    return (
                        <li key={id} className="shadow">
                            <img src={img} alt={title} />
                            <div>
                                <h5>{id} - {title}</h5>
                                <a href={url}>Profile</a>
                            </div>
                        </li>
                    );
                })}
            </ul>
        </>
    );
};

export default FetchComponents;
