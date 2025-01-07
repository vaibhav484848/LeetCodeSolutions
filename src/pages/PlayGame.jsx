import { useLocation } from "react-router-dom";
import { MaskedText } from "../components/MaskedText/MaskedText";
import { LetterButton } from "../components/LetterButton/LetterButton";
import { useContext, useState } from "react";
import { HangMan } from "../components/HangMan/Hangman";
import { WordContext } from "../Context/WordContext";
import Button from "../components/Button/Button";
import WordStore from "../Store/WordStore";



function PlayGame(){
    // const location=useLocation();
    // const {state}=location;
    // const{word,setword,wordList,setWordList} =useContext(WordContext);
    const{word,setword,setWordList} =useContext(WordContext);

    const{wordList}=WordStore();
    const[guessedLetter,setguessedLetter]=useState([]);
    const[step,setStep]=useState(0);
    console.log(word,"hello");
    const orSet = new Set((word || "").toUpperCase().split(""));

    
    function onClickHandler(letter){
        if(orSet.has(letter)){
            console.log("hello");

        }
        else{
            setStep(step+1);
        }

        setguessedLetter([...guessedLetter,letter]);
        
    }
    function eventHandler(){
        if(wordList.length===0) return;
        const num=Math.floor(Math.random()*wordList.length)
        setword(wordList[num].wordSelected);
        setguessedLetter([]);

        setStep(0);


    }
    return (
        <>
        <h1>Play Game </h1>
        {wordList.map((ele)=>{
            return(
            <li key={ele.id}>{ele.wordSelected}</li>
            )
        })}
        <Button
        styletype="primary"
        text="Restart"
        eventHandler={eventHandler}
        />
        {/* {wordList.map((ele)=>{
            return(
                <li key={ele.id}>{ele.wordSelected}</li>
            )
        })} */}
        <MaskedText 
        originalWord={word}
        // guessedLetters={['H','E']}
        guessedLetter={guessedLetter}
        />
        <LetterButton
        originalWord={word}
        guessedLetter={guessedLetter}
        onClickHandler={onClickHandler}
        />

        <HangMan
        step={step}
        />




        </>
        

        
            
        
    );
}
export default PlayGame;