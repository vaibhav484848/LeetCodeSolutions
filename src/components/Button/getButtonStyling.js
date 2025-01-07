function getButtonStyling(styletype){
    if(styletype==="primary") return "bg-blue-300"
    else if(styletype==="secondary") return "bg-green-300"
    else if(styletype==="home" ) return "bg-gray-300"
    else return "bg-red-300";
}
export default getButtonStyling;