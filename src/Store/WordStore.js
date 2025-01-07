import { create } from "zustand";

const WordStore=create((set)=>({
    wordList:[],
    word:'',
    setWordList:(list)=>{
        set((state)=>{
            return {
                ...state,
                wordList:list
            }
        })
    }
}))

export default WordStore;

// const WordStre=create((set)=>{
//     return{
//     wordList:[],
//     word:'',
//     setList:(list)=>{
//         set((state)=>{
//             return {
//                 ...state,
//                 wordList:list
//             }
//         })
//     }
// }
// })

const Wstore=create((set)=>({
    word:'',
    wordList:[],
    setWordList:(list)=>{
        set((state)=>{
            return{
                ...state,
                wordList:list,
            }
        })

        
    }

}))