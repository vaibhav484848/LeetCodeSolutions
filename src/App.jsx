
import Button from './components/Button/Button';
import './App.css'
import TextInput from './components/TextInput/TextInput';
import TextInputForm from './components/TextInputForm/TextInputForm';
import TextInputFormContainer from './components/TextInputForm/TextInputFormContainer';
import { Route, Routes } from 'react-router-dom';
import PlayGame from './pages/PlayGame';
import StartGame from './pages/StartGame';
import { HomePage } from './pages/HomePage';
import { WordContext } from './Context/WordContext';
import { useState } from 'react';

function App() {

  const[wordList,setWordList]=useState([]);
  const [word,setword]=useState("");
  

  return (
    <WordContext.Provider value={{wordList,setWordList,word,setword}}>

    <Routes>
      <Route path='/start' element={<StartGame/>}/>
      <Route path='/play' element={<PlayGame/>}/>
      <Route path='/' element={<HomePage/>}/>

      {/* <div>
      <StartGame/>
      </div> */}

      </Routes>

      </WordContext.Provider>
      


    
      
        //  <div>
        //  <TextInputFormContainer

        //   />

        //  </div>

         
      
      
      
    
  )
}

export default App;
