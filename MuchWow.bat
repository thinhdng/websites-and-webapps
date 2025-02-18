@echo off
mode 800
:loop
Set /a num=(%Random% %%9)+1

color %num%
cls
echo:
echo:
echo:
echo ?88   d8P d8888b  88bd88b?88   d8P                           
echo d88  d8P'd8b_,dP  88P'  `d88   88                            
echo ?8b ,88' 88b     d88     ?8(  d88                            
echo `?888P'  `?888P'd88'     `?88P'?8b                           
echo                                 )88                          
echo                                ,d8P                          
echo                             `?888P'                          
echo                 d8b                     ,d8888b          d8b 
echo                 88P                     88P'             88P 
echo                d88                   d888888P           d88  
echo  d8888b d8888b 888   d8888b   88bd88b  ?88'    ?88   d8P888  
echo d8P' `Pd8P' ?88?88  d8P' ?88  88P'  `  88P     d88   88 ?88  
echo 88b    88b  d88 88b 88b  d88 d88      d88      ?8(  d88  88b 
echo `?888P'`?8888P'  88b`?8888P'd88'     d88'      `?88P'?8b  88b
echo:                                                             
echo:                                                             
echo:                                                             
echo                               d8b                           
echo                               ?88                           
echo                                88b                          
echo  88bd8b,d88b  ?88   d8P d8888b  888888b                     
echo  88P'`?8P'?8b d88   88 d8P' `P  88P `?8b                    
echo d88  d88  88P ?8(  d88 88b     d88   88P                    
echo d88' d88'  88b` ?88P'?8b`?888P'd88'   88b                    
echo:                                                             
echo:                                                             
echo:                                                             
echo:                                                             
echo:                                                             
echo:                                                              
echo ?88   d8P  d8P d8888b  ?88   d8P  d8P                       
echo d88  d8P' d8P'd8P' ?88 d88  d8P' d8P'                       
echo ?8b ,88b ,88' 88b  d88 ?8b ,88b ,88'                        
echo `?888P'888P'  `?8888P' `?888P'888P'                         
echo:                                                             
echo:                                                             
echo: 
timeout 1 >nul
goto :loop