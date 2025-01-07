export function getMaskedArray(originalWord,guessedLetter){
    console.log(guessedLetter);
    originalWord=originalWord.toUpperCase().split("");
    guessedLetter=guessedLetter?.map((ele)=>ele.toUpperCase());

    const guessedLetterSet=new Set(guessedLetter);

    const result=originalWord.map((ele)=>{
        if(guessedLetterSet.has(ele)){
            return ele;
        }
        else{
            return "_";
        }
    });

    return result;


}