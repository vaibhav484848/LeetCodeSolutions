import { getMaskedArray } from "./MaskingUtility";

export function MaskedText({originalWord,guessedLetter}){
    const arr=getMaskedArray(originalWord,guessedLetter);

    return(
       <div>
            {arr.map((ele,index)=>{
                return(
                    <span key={index} className="mx-1">{ele}</span>
                    
                )
                
            })}
        </div>

    );

}