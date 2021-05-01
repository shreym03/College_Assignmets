//Dataflow description of a 2-to-4-line decoder 
module decoder_df (A,B,E,D);
   input A,B,E;
   output [0:3] D;
   assign D[0] = ~(~A & ~B & ~E),
      D[1] = ~(~A & B & ~E),
      D[2] = ~(A & ~B & ~E),
      D[3] = ~(A & B & ~E);
endmodule

module testdecoder;
  reg A,B,E;
  wire [0:3]D;
  decoder_df d (A,B,E,D);
  initial
    begin
      E = 1'b1; 
      #10 E = 1'b0; A = 1'b0; B = 1'b0;
      #10 E = 1'b0; A = 1'b0; B = 1'b1;
      #10 E = 1'b0; A = 1'b1; B = 1'b0;
      #10 E = 1'b0; A = 1'b1; B = 1'b1;
    end
initial
#100 $finish; 
endmodule    
