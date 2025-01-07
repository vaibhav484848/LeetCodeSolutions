import { Link } from "react-router-dom";
import Button from "../components/Button/Button";
import js from "@eslint/js";
import { useContext, useEffect, useState } from "react";
import { WordContext } from "../Context/WordContext";
import WordStore from "../Store/WordStore";

export function HomePage(){

    // const{word,setword,wordList,setWordList} =useContext(WordContext);
    const{word,setword,wordList} =useContext(WordContext);

    const{setWordList}=WordStore()
    // const [word,setword]=useState("");
    async function fetchWords(){
        const response=await fetch('http://localhost:3000/words')
        const data=await response.json();
        const rand=Math.floor(Math.random()*data.length);
        setword(data[rand].wordSelected);

        setWordList(data);

        // setWordList([...data]);




    }

    useEffect(()=>{
        fetchWords();
    },[]);
    return (
        <div>
            
            <div>
            <Link to="/play"  > 
            <Button
            text="SinglePlayer"
            styletype="home"
            />
            </Link>

            </div>
            

            
            <div>
            <Link to="/start">

            <Button
            text="MultiPlayer"
            styletype="primary"
            />

            </Link>
            </div>
        </div>

    )
}