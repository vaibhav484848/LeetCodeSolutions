

const letter="QWERTYUIOPASDFGHJKLZXCVBNM".split("");
// letter.split("");

export function LetterButton({originalWord,guessedLetter,onClickHandler}){

    const setOrg=new Set(originalWord?.toUpperCase().split("")||[]);
    const setGue=new Set(guessedLetter);

    function handleClick(event){
        
        onClickHandler?.(event.target.value);
    }
    
    const buttonStyle=function(letter){
        if(setGue.has(letter)){
            
            return setOrg.has(letter)?"bg-green-300":"bg-red-300";
        }
        else return "bg-blue-300";
    }
    
    const buttons=letter.map((buttonletter)=>{

        


        return(
            
            <button key={buttonletter} 
            value={buttonletter}
            className={`h-12 w-12 m-1 text-white rounded-md ${buttonStyle(buttonletter)}`}
            onClick={handleClick}
            disabled={setGue.has(buttonletter)}
            >
                {buttonletter}


            </button>

        )
    })

    return(
        <>
        <div>
            {buttons}

        </div>
        </>
        
    )

}