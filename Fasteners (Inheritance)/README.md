# Fasteners - Inheritance 

This project was part of a Queen's Computer Engineering Java course. 

Start with Fastener.java, it includes a tree diagram of the heirarchy.

## Project Statement

The Fastenal web site (https://www.fastenal.com/products/fasteners?r=~|categoryl1:%22600000%20Fasteners%22|~) provides a very nice illustration of a natural hierarchy. We will use this representation to help build a code model of a small portion of this hierarchy for Fasteners. Our portion of the hierarchy will need to hold descriptions of Carriage Bolts, Wood Screws, Wing Nuts and Common Nails only:

A **Carriage Bolt** is described by the following fields: 
 - Diameter / Thread Size
 - Length
 - Material
 - Finish
 - Unit Price
 - Number per Unit
These fields would describe any Bolt, but CarriageBolt should extend Bolt.

A **Wood Screw** is described by the following fields: 
 - Diameter / Thread Size
 - Length
 - Material
 - Finish
 - Head
 - Drive
 - Point
 - Unit Price
 - Number per Unit
Point is unique to Wood Screws, but other Screws would contain all other fields.

A **Wing Nut** is described by the following fields: 
 - Diameter / Thread Size
 - Material
 - Finish
 - Unit Price
 - Number per Unit
 
A **Common Nail**, or any Nail for that matter, is described by the following fields: 
 - Material
 - Finish
 - Size
 - Length
 - Gauge
 - Unit Price
 - Number per Unit
Not all fields have been included for these fasteners - Manufacturer, Grade, Standard and Thread Type have been left out.

## Restrictions on Field Values

Each of the fields listed above are restricted to certain values. The inches symbol, ", can be omitted from the attribute values. Some further simplifications have been applied to those shown on the Fastenal site.

 - Materials for all Fasteners: Brass, Stainless Steel, Steel.
 - Finishes for Steel only: Chrome, Hot Dipped Galvanized, Plain, Yellow Zinc, Zinc.
 - Finish for Brass and Stainless Steel Materials: Plain.
 - Additional Finishes for Steel Screws only: Black Phosphate, ACQ 1000 Hour, Lubricated.
 - Diameter/Thread Size for any threaded Fastener: #8-13, #8-15, #8-32, #10-13, #10-24, #10-32, 1/4"-20, 5/16"-18, 3/8"-16, 7/16"-14, 1/2"-13, 5/8"-11, 3/4"-10.
 - Lengths for Bolts and Screws: 1/2" to 6" in units of 1/4", 6" to 11" in units of 1/2", 11 to 20" in units of 1".
 - Head for all Screws: Bugle, Flat, Oval, Pan, Round.
 - Drive for all Screws: 6-Lobe, Philips, Slotted, Square
 - Point for Wood Screws: Double Cut, Sharp, Type 17
 - Material for all Nails: Steel.
 - Finishes for Common Nails: Bright, Hot Dipped Galvanized.
 - Sizes for Common Nails: 6D, 8D, 10D, 12D, 16D, 60D.
 - Lengths for Common Nails: 2, 2.5, 3, 3.25, 3.5, 6 (in inches).
 - Gauge for Common Nails: 2, 8, 9, 10.25, 11.5
 - "Number per Unit" must be at least 1, but could be as high as 10,000. This number will always be one or if higher, evenly divisible by 5. The Unit Price, in dollars, must be greater than zero and is the price per unit, where a unit could be anywhere from 1 to 10,000 fasteners.
