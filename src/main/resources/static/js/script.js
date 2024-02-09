console.log("this is script file")

/* below is js function to open/hide sidebar */

const toggleSidebar=()=>{
    
    if($(".sidebar").is(":visible")) {
    	//true
    	//band krna hai
    	$(".sidebar").css("display","none");
    	$(".content").css("margin-left","0%");
    }else{
    	//false
    	//dikhana hai
    	$(".sidebar").css("display","block");
    	$(".content").css("margin-left","20%");
    }
};