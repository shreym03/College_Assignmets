//HDL Example 1
//----------------------     
//Stimulus for simple circuit
module stimcrct;
reg A,B,C;
wire x,y;
circuit_with_delay cwd(A,B,C,x,y);
initial
   begin
        A = 1'b0; B = 1'b0; C = 1'b0;
     #100
        A = 1'b1; B = 1'b1; C = 1'b1;
     #100  $finish; 
   end
endmodule

//Description of circuit with delay 
module circuit_with_delay (A,B,C,x,y);
   input A,B,C;
   output x,y;
   wire e;
   and  g1(e,A,B);
   or   g3(x,e,y);
   not  g2(y,C);
endmodule
