import { useEffect } from "react";
import Button from "../Button/Button";
import TextInput from "../TextInput/TextInput";

function TextInputForm({text="hide",type,handleFormSubmit,handleTextInputChange,eventHandler}){

    useEffect(()=>{
        console.log("hello useEffect");
    });
    

    return(

        <form onSubmit={handleFormSubmit}>
            <div>
                <TextInput
                type={type}
                label="Enter a word or a phrase"
                placeholder="Enter a word or a phrase here..."
                onChangeHandler={handleTextInputChange}
                
                />

            </div>

            <div>
                <Button
                stylename="warning"
                
                text={type==="password"?"show":"hide"}
                eventHandler={eventHandler}

                />
            </div>

            <div>
                <Button
                type="submit"
                styletype="primary"
                text="submit"

                />
            </div>
            
            </form>
    )
}
export default TextInputForm;