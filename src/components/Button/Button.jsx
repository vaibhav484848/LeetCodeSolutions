import getButtonStyling from './getButtonStyling'
function Button({text,eventHandler,styletype,type}){
    return(
        <button className={`m border-2 border-black px-4 py-4 ${getButtonStyling(styletype)}`} onClick={eventHandler}
        type={type}
        >
            {text}
        </button>
    )
}
export default Button;