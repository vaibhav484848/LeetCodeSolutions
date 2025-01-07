function TextInput({type="text",label,placeholder,value,onChangeHandler}){
    return(
        <label >
            <span className="text-gray-700">
            {label}
            </span>
            <input 
            type={type} className="px-4 py-2 border-gray-500 rounded-md w-full" 
            placeholder={placeholder} 
            // value={value} 
            onChange={onChangeHandler}
            />

        </label>

    )


}
export default TextInput;