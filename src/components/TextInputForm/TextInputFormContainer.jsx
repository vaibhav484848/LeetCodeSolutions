
import { useState } from "react";
import TextInputForm from "./TextInputForm";
import { useNavigate } from "react-router-dom";
import { MaskedText } from "../MaskedText/MaskedText";

function TextInputFormContainer(){
    let [inputType,changeInput]=useState("password");

    const[value,setValue]=useState("");

    const navigate=useNavigate();
    function handleFormSubmit(event){
        event.preventDefault();
        if(value){
            setTimeout(()=>{
                navigate("/play",{
                    state:{
                        wordSelected:value
                    }
                });
            },2000);
            
        }
        
        console.log("Form submitted");
    }
    
    function handleTextInputChange(event){
        console.log("Text input changed");
        console.log(event.target.value);
        setValue(event.target.value);
    
    }
    function eventHandler(event){
        event.preventDefault();
        if(inputType==="password"){
            changeInput("text");
        }
        else{
            changeInput("password");
        }
    }
    
    return (
        // <TextInputForm
        
        // type={inputType}
        // handleFormSubmit={handleFormSubmit}
        // handleTextInputChange={handleTextInputChange}
        // eventHandler={eventHandler}
    
        // />
        <div>
            <TextInputForm
        
        type={inputType}
        handleFormSubmit={handleFormSubmit}
        handleTextInputChange={handleTextInputChange}
        eventHandler={eventHandler}
    
        />
        {/* <MaskedText
        originalWord="hello"
        guessedLetters={['h','o']}
        /> */}
        </div>
    )
}
export default TextInputFormContainer;