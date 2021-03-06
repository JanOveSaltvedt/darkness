from sys import argv

bulbs = {}
patternFile = argv[1]
boxFile = argv[2]
for line in open(patternFile):
	items = line.split()
	bulb = int(items[0])
	rgb = [int(x) for x in items[4:7]]
	bulbs[bulb] = rgb

for line in open(boxFile):
	items = line.split()
	if not items or items[1] == '-':
		continue
	boxItems = items[0].split('.')
	box = int(boxItems[0])
	boxLed = int(boxItems[1])
	bulb = int(items[1])
	rgb = bulbs[bulb]
	for i in range(len(rgb)):
		physical = (box - 1) * 18 + (boxLed - 1) * 3 + (i + 1)
		print('%d\t%d' % (rgb[i], physical))
