/*
var series = {"iller":[{"id": "TR.KO", "value": 23},
    {"id": "TR.AN", "value": 98},
    {"id": "TR.CO", "value": 23},
    {"id": "TR.IS", "value": 23},
    {"id": "TR.IZ", "value": 23},
    {"id": "TR.CA", "value": 2},
]}
*/
var series = JSON.parse(mapdata);
var numbers= [];
for(i in series.iller){numbers [i] = series.iller[i].value};
//console.log(numbers);
// Datamaps expect data in format:
// { "USA": { "fillColor": "#42a844", numberOfWhatever: 75},
//   "FRA": { "fillColor": "#8dc386", numberOfWhatever: 43 } }
var dataset = {};
// We need to colorize every country based on "numberOfWhatever"
// colors should be uniq for every value.
// For this purpose we create palette(using min/max series-value)
var onlyValues = numbers//series.map(function(obj){ return obj[1]; });
var minValue = Math.min.apply(null, onlyValues),
    maxValue = Math.max.apply(null, onlyValues);


// create color palette function
// color can be whatever you wish
var paletteScale = d3.scale.linear()
    .domain([minValue,maxValue])
    .range(["#EFEFFF","#02386F"]); // blue color

// fill dataset in appropriate format
// fill dataset in appropriate format
for(i in series.iller){ //
    // item example value ["USA", 70]
    var value = series.iller[i].value;
    dataset[series.iller[i].properties.id] = {
        numberOfThings: value, fillColor: paletteScale(value),
        hover1text:series.iller[i].h1text, hover1value:series.iller[i].h1value,
        hover2text:series.iller[i].h2text, hover2value:series.iller[i].h2value,
        hover3text:series.iller[i].h3text, hover3value:series.iller[i].h3value,
        hover4text:series.iller[i].h4text, hover4value:series.iller[i].h4value
    };
};
console.log(dataset);
// render map
var map = new Datamap({
    element: document.getElementById('container'),
    scope:'tur',
    projection: 'equirectangular', // big world map
    // countries don't listed in dataset will be painted with this color
    fills: { defaultFill: '#F5F5F5' },
    data: dataset,

    geographyConfig: {
        dataUrl:'/js/json/tur.json',
        borderColor: '#b1b1b1',
        highlightBorderWidth: 2,
        // don't change color on mouse hover

        highlightFillColor: function(geo) {
            return geo['fillColor'] || '#F5F5F5';
        },
        // only change border
        highlightBorderColor: '#696969',
        // show desired information in tooltip

        popupTemplate: function(geo, data) {
            // don't show tooltip if country don't present in dataset
            if (!data) { return ['<div class="hoverinfo">',
                '<strong>', geo.properties.name, '</strong>',

                '</div>'].join(''); }
            // tooltip content
            return ['<div id ="mousehover" class="hoverinfo">',
                '<strong>', geo.properties.name, '</strong>',
                '<br>Toplam Evrak: <strong>', data.numberOfThings, '</strong>',
                '<br>',data.hover1text ,' : <strong>', data.hover1value, '</strong>',
                '<br>',data.hover2text ,' : <strong>', data.hover2value, '</strong>',
                '<br>',data.hover3text ,' : <strong>', data.hover3value, '</strong>',
                '<br>',data.hover4text ,' : <strong>', data.hover4value, '</strong>',
                '</div>'].join('');
        },
         setMyProjection: function(element) {
            var projection = d3.geo.equirectangular()
                .center([-72, 43])
                .rotate([4.4, 0])
                .scale(100)
                .translate([element.offsetWidth / 2, element.offsetHeight / 2]);
            var path = d3.geo.path()
                .projection(projection);

            return {path: path, projection: projection};
        }
    }

});

/*
var map = new Datamap({
    element: document.getElementById('container1'),
    scope:'tur',
    projection: 'equirectangular', // big world map
    // countries don't listed in dataset will be painted with this color
    fills: { defaultFill: '#F5F5F5' },
    data: dataset
})
*/