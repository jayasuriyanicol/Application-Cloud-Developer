import React, { useEffect, useState } from "react";
import axios from "axios";

const url = "https://jsonplaceholder.typicode.com/users";
const RenderCondizionale = () => {

    const [isLoading, setIsLoading] = useState(true);
    const [isError, setIsError] = useState(true);
    const [users, setUsers] = useState([]);

    const getData = async () => {
        setIsError(false);
        setIsLoading(true);
        try {
            const response = await axios.get(url);
            setUsers(response.data);
        } catch (err) {
            console.log(err);
            setIsError(true);
        }
        setIsLoading(false);
    };

    useEffect(() => {
        getData();
    }, [])

    if (isLoading) {
        return <Loading></Loading>;
    }

    if (isError) {
        return <h2>Attenzione c'è un errore</h2>;
    }

    return <div><ul>
        {
            users.map((u) => {
                const { id, name, username, email } = u
                return (
                    <li key={id}>
                        <div>
                            <h5>{id} - {name} - {username} - {email}</h5>
                        </div>
                    </li>
                )

            })
        }
    </ul></div>;
};

const Loading = () => {
    return <h2>Loading...</h2>;
};

export default RenderCondizionale;