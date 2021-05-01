//HDL Example 2
//----------------------     
//Stimulus for Circuit specified with Boolean equations
module stimcrct;
reg A,B,C,D;
wire x,y;
circuit_bln cb(x,y,A,B,C,D);
initial
   begin
        A = 1'b0; B = 1'b0; C = 1'b0; D =1'b0;
     #100
        A = 1'b1; B = 1'b1; C = 1'b1; D =1'b1;
     #100  $finish; 
   end
endmodule    

//Circuit specified with Boolean equations
module circuit_bln (x,y,A,B,C,D);
   input A,B,C,D;
   output x,y;
   assign x = A | (B & C) | (~B & C);
   assign y = (~B & C) | (B & ~C & ~D);
endmodule
